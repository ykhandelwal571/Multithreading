# 🚀 MultiThreadedApplication 🧵

This Java program demonstrates a simple multithreaded application where multiple threads are created to perform a task concurrently while synchronized using locks. 🎯

## Code Explanation 💡

1. **Import Statements**:
   - The `java.util.concurrent.locks.Lock` interface is imported to provide locking mechanisms for thread synchronization. 🔒
   - The `java.util.concurrent.locks.ReentrantLock` class is imported, which implements the `Lock` interface and provides synchronization features based on the concept of reentrant locks. 🔓

2. **Main Class - MultiThreadedApplication**:
   - `NUM_THREADS` and `NUM_ITERATIONS` are defined as constants representing the number of threads and the number of iterations each thread will perform, respectively. 📊
   - Inside the `main` method:
     - An instance of `ReentrantLock` named `lock` is created. This will be used for thread synchronization. 🧷
     - A loop creates and starts multiple threads (`Worker` instances) to perform concurrent tasks. 🔄

3. **Worker Class**:
   - This is a nested static class within `MultiThreadedApplication`.
   - Implements the `Runnable` interface, allowing instances of this class to be executed by threads. 🏃‍♂️
   - It has a constructor that takes a `Lock` object as a parameter and assigns it to the `lock` field. 🛠️
   - The `run` method contains the actual task to be performed by each thread:
     - It iterates `NUM_ITERATIONS` times, each time acquiring the lock before executing the task. ⏳
     - Within the loop, it prints the thread's name and the current iteration number. 📝
     - It simulates some work by pausing the thread for 100 milliseconds using `Thread.sleep(100)`. ⏱️
     - After completing the task, it releases the lock using `lock.unlock()` in the `finally` block to ensure the lock is always released, even if an exception occurs. 🔑

## Running the Program 🚀

To run the program, simply execute the `main` method in the `MultiThreadedApplication` class. This will create multiple threads, each performing a set number of iterations while synchronized using a lock. 💥
