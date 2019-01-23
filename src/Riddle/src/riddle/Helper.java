/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remind;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Seven7
 */
public class Helper extends Thread {

    public ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    public void run(){
        Future<String> future;
        future = executor.submit(new Task());

        try {
            System.out.println("Started..");
            System.out.println(future.get(2, TimeUnit.SECONDS));
            System.out.println("Finished!");
            this.help();
        } catch (TimeoutException e) {
            future.cancel(true);
            System.out.println("Terminated!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }

        executor.shutdownNow();
    }

    public void help() {
        //executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.print("Give some help");
    }
}

class Task implements Callable<String> {

    boolean interrupted = false;

    @Override
    public String call() throws Exception {
        while (!Thread.interrupted()) {
            // Do your long running task here.
        }
        return "Ready!";
    }
}
