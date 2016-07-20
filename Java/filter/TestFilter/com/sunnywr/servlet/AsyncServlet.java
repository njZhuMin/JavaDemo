package com.sunnywr.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AsyncServlet", value = "/servlet/AsyncServlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet start at " + new Date());
        AsyncContext context = request.startAsync();
        new Thread(new Executor(context)).start();
        System.out.println("Servlet finish at " + new Date());
    }

    public class Executor implements Runnable {
        private AsyncContext context;

        public Executor(AsyncContext context){
            this.context = context;
        }
        public void run() {
            try {
                Thread.sleep(1000 * 10);

                //context.getRequest();
                //context.getResponse();
                System.out.println("Thread finish at " + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
