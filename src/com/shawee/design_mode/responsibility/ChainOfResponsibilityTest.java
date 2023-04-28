package com.shawee.design_mode.responsibility;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Request request = new Request.RequestBuilder().frequentOk(true).loggedOn(false).build();
        Handler handler = new RequestFrequentHandler(new LoginHandler(null));
        if (handler.process(request)) {
            System.out.println("业务正常处理");
        } else {
            System.out.println("业务出现异常");
        }
        ;
    }
}

class Request {
    private boolean loggedOn;
    private boolean frequentOk;
    private boolean isPermits;
    private boolean containsSensitiveWords;
    private String requestBody;

    public Request(boolean loggedOn, boolean frequentOk, boolean isPermits, boolean containsSensitiveWords) {
        this.loggedOn = loggedOn;
        this.frequentOk = frequentOk;
        this.isPermits = isPermits;
        this.containsSensitiveWords = containsSensitiveWords;
    }

    static class RequestBuilder {
        private boolean loggedOn;
        private boolean frequentOk;
        private boolean isPermits;
        private boolean containsSensitiveWords;

        RequestBuilder loggedOn(boolean loggedOn) {
            this.loggedOn = loggedOn;
            return this;
        }

        RequestBuilder frequentOk(boolean frequentOk) {
            this.frequentOk = frequentOk;
            return this;
        }

        RequestBuilder isPermits(boolean isPermits) {
            this.isPermits = isPermits;
            return this;
        }

        RequestBuilder containsSensitiveWords(boolean containsSensitiveWords) {
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }

        Request build() {
            return new Request(this.loggedOn, this.frequentOk, this.isPermits, this.containsSensitiveWords);
        }
    }

    public boolean isLoggedOn() {
        return loggedOn;
    }

    public void setLoggedOn(boolean loggedOn) {
        this.loggedOn = loggedOn;
    }

    public boolean isFrequentOk() {
        return frequentOk;
    }

    public void setFrequentOk(boolean frequentOk) {
        this.frequentOk = frequentOk;
    }

    public boolean isPermits() {
        return isPermits;
    }

    public void setPermits(boolean permits) {
        isPermits = permits;
    }

    public boolean isContainsSensitiveWords() {
        return containsSensitiveWords;
    }

    public void setContainsSensitiveWords(boolean containsSensitiveWords) {
        this.containsSensitiveWords = containsSensitiveWords;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }
}

abstract class Handler {
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}

class RequestFrequentHandler extends Handler {
    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("访问频率控制。");
        if (request.isFrequentOk()) {
            Handler handler = getNext();
            if (null == handler) {
                return true;
            }
            if (next.process(request)) {
                return true;
            }
        }
        return false;
    }
}

class LoginHandler extends Handler {

    public LoginHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("登录验证。");
        if (request.isLoggedOn()) {
            Handler handler = getNext();
            if (null == handler) {
                return true;
            }
            if (next.process(request)) {
                return true;
            }
        }
        return false;
    }
}