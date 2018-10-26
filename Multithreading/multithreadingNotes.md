/*****************************************************************************************************************************************
*
* Multithreading
* Written By :- Aadish Joshi
* Last Revised:- Oct' 25, 2018.
*
*****************************************************************************************************************************************/
The basic difference between Multitasking and multithreading is that Multitasking allows  CPU to perform multiple tasks (program, process, task, threads) simultaneously whereas, Multithreading allows multiple threads of the same process to execute simultaneously.

In multitasking system has to allocate separate memory and resources to each program that CPU is executing.	In multithreading system has to allocate memory to a process, multiple threads of that process shares the same memory and resources allocated to the process.

import java.lang.Thread; (Throws InterruptException e)

Thread() :- Constructs new thread.
void run() :- Must override and should write a code to be executed
void start() :- starts the thread by calling run()
void sleep(millis) :- delay in millis
void interrupt() :-  sends interrupt request to the thread
boolean interrupt() :- asks wether current thread has been interrupted.

***************************************************************************
Thread states
***************************************************************************
new :- new thread recently created; Java has not started a code execution under that thread.
runnable :- Once you invoke start method, the thread is runnable. OS allocates each thread a time (Mutual exclusion of the threads is recommended). Runnable thread may or may not be running. It is ready to run. But running is CPU based.
blocked :- Sleep, suspend, wait methods mutually exclude thread from other threads. To get out use (if suspend) resume method or (if wait) notify, notifyAll method.
dead :- stop method.

finding out the thread state
boolean isAlive() :- true if state is started/ runnable
void join() :- waits for specified thread to be cease to be alive






