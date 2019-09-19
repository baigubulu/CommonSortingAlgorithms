# 线程池相关的概念
- 基本组成：
  1. 线程管理器
  2. 工作线程
  3. 任务接口
  4. 任务队列
  
- ThreadPoolExecutor类
  1. 使用该类创建一个线程池
  2. new ThreadPoolExecutor(corePoolSize, maximumPoolSize,keepAliveTime, milliseconds,runnableTaskQueue, threadFactory,handler);
  3. 创建线程池的几个关键参数
     1. 线程池的基本大小(corePoolSize)
     2. 线程池最大大小(maximumPoolSize)
     3. 任务队列(runnableTaskQueue)
     4. ThreadFactory
     5. 拒绝策略
     6. 线程活动保持时间
     7. 线程活动保持时间的单位

- 向线程池提交线程的两种方式
  1. executor(): 该方式没有返回值，所以无法判断任何是否被线程池执行成功
  2. submit(): 返回一个future，可以通过future来判断任务是否执行成功，通过future的get方法来获取返回值

- 关闭线程的方式
  1. shutdown():该函数只是将线程池的状态设置成SHUTDOWN状态，然后终端所有正在执行任务的线程
  2. shutDownNow(): 遍历线程池中的工作线程，然后逐个调用线程的interrupt方法来中断线程，所以无法响应中断的任务可能永远无法终止。shutdownNow会首先将线程池的状态设置成STOP，然后尝试停止所有的正在执行或暂停任务的线程，并返回等待执行任务的列表。

- 线程池的处理流程：
  1. 如果线程数量未达到corePoolSize，则新建一个线程(核心线程)执行任务
  2. 线程数量达到了corePoolSize，则将任务移入到等待队列
  3. 队列以满，新建线程(非核心线程)执行任务
  4. 队列已满，总线程数又达到了maximumPoolSize，就会由拒绝策略抛出异常

- 自动决绝策略
  1. AbortPolicy： 不执行新任务，直接抛出异常，提示线程池已满，线程池默认策略
  2. DiscardPolicy：不执行新任务，也不抛出异常，基本上为静默模式
  3. DisCardOldSetPolicy：将消息队列中第一个任务替换为当前新进来的任务执行
  4. CallerRunPolicy： 用于被拒绝任务的处理程序，它直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务。
  
- java提供的四种线程池
  1. CachedThreadPool(): 可缓存线程池
     线程数无限制
     有空闲线程则复用，没有空闲线程则新建线程
  2. FixedThreadPool(): 定长线程池
     可控制线程的最大并发数
     超出的线程会在队列中等待
  3. ScheduledThreadPool(): 定时线程池
      支持定时及周期性任务执行
  4. SingleThreadExecutor(): 单线程化线程池
     有且仅有一个工作线程执行任务
     所有的任务按照制定顺序执行，即遵循队列的出队规则

- 线程池的五种状态：
  1. 初始状态为RUNNING，能够接收新的任务，以及对已添加的任务进行处理
  2. SHUTDOWN 状态，不接收新任务，但能够处理已添加的任务。
  3. STOP状态，不接收新任务，不处理已添加的任务，并且会中断正在处理的任务
  4. 当所有的任务都停止，ctl记录仪的任务数量为0，线程池的状态为TIDYING状态，这其中还涉及到terminated()函数
  5. 当线程池的状态为SHUTDOWN状态的时候，阻塞队列为空并且线程池中执行的任务也为空的时候，线程池的状态就会由SHUTDOWN -> TIDYING
  6. 当线程池在STOP状态下，线程池中执行的任务为空时，就会由STOP -> TIDYING。线程池彻底终止，就变成TERMINATED状态。线程池处在TIDYING状态时，执行完terminated()之后，就会由 TIDYING -> TERMINATED。
