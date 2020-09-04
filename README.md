# CrashDemo
1 主线程 crash
    Handler handler = new Handler(getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Looper.loop();
                    } catch (Exception e) {
                        Toast.makeText(instance, "抛出了异常", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

2 crashHandler
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler";
    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull final Throwable throwable) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(CrashApplication.instance,"UncaughtException："+throwable.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
3 子线程crash

  加上 Thread.setDefaultUncaughtExceptionHandler(new CrashHandler());

  public void click(View view) throws Exception {
       new Thread(new Runnable() {
           @Override
           public void run() {
               TextView textView = null;
               textView.setText("hell,word");
           }
       }).start();
    }
