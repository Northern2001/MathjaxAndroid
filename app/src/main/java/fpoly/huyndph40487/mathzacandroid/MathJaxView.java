package fpoly.huyndph40487.mathzacandroid;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.Nullable;

public class MathJaxView extends WebView {

    String text, config, style, preDefinedConfig;
    boolean isWidthWrapContent;

    public MathJaxView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setConfig(
                "MathJax.Hub.Config({" +
                        "    messageStyle: 'none'," +
                        "    CommonHTML: {" +
                        "      linebreaks: { automatic: true, width: \"fit-content\" }" +
                        "    }," +
                        "    tex2jax: {" +
                        "      inlineMath: [ ['$','$'], ['\\\\(', '\\\\)'] ]," +
                        "      displayMath: [ ['$$','$$'], ['\\\\[', '\\\\]'] ]," +
                        "      processEscapes: true" +
                        "    }," +
                        "    TeX: {" +
                        "      extensions: [\"file:///android_asset/MathJax/extensions/TeX/mhchem.js\"]," +
                        "      mhchem: {legacy: false}" +
                        "    }" +
                        "});"
        );
        preDefinedConfig = "TeX-MML-AM_CHTML";


        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        setBackgroundColor(Color.TRANSPARENT);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        removeJavascriptInterface("AndroidInterface");
        addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void getWidthContent(final String withContent) {

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (isWidthWrapContent) {
                            ViewGroup.LayoutParams layoutParams = getLayoutParams();
                            layoutParams.width = convertDpSize(getContext(), Integer.parseInt(withContent) + 22);
                            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                            setLayoutParams(layoutParams);
                        }
                    }
                });
            }
        }, "AndroidInterface");
    }

    private int convertDpSize(Context context, int px) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) ((float) px * density + 0.5f);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public void setConfig(String config) {
        this.config = minifyConfig(config);
    }

    private String minifyConfig(String config) {
        return config.replace("\n", "").replace(" ", "");
    }

    public void setWidthWrapContent(boolean isWidthWrapContent) {
        this.isWidthWrapContent = isWidthWrapContent;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Nullable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        loadDataWithBaseURL("about:blank",
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">" +
                        "<html>" +
                        "<style>" +
                        "@font-face {" +
                        "font-family: MyFont; " +
                        " src: url(\"file:///android_asset/fonts/averta.ttf\") }" +
                        "body { font-family: 'Times New Roman' }" +
                        getStyle() +
                        "</style>" +
                        "<script type=\"text/javascript\" async src=\"file:///android_asset/MathJax/MathJax.js?config=" + preDefinedConfig + "\"></script>" +
                        "<script type=\"text/x-mathjax-config\">" +
                        config +
                        "MathJax.Hub.Queue(function() {" +
                        "document.getElementById(\"formula\").style.visibility = '';" +
                        "var content = document.getElementById(\"formula\");" +
                        "AndroidInterface.getWidthContent(content.offsetWidth);" +
                        "});" +
                        "</script>" +
                        "<script type=\"text/javascript\" async src=\"file:///android_asset/MathJax/MathJax.js?config=" + preDefinedConfig + "\"></script>" +
                        "<body>" +
                        "<div id=\"formula\" style=\"visibility: hidden; margin: 0; width: fit-content; font-size: 22px; color: #3D4A54\">" +
                        text +
                        "</div>" +
                        "</body>", "text/html", "utf-8", "");
    }

    public void setTextWord(String text) {
        this.text = text;
        loadDataWithBaseURL("about:blank",
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">" +
                        "<html>" +
                        "<style>" +
                        "@font-face {" +
                        "font-family: MyFont; " +
                        " src: url(\"file:///android_asset/fonts/averta.ttf\") }" +
                        "body { font-family: 'Times New Roman' }" +
                        "img { max-width: 620px }" +
                        getStyle() +
                        "</style>" +
                        "<script type=\"text/javascript\" async src=\"file:///android_asset/MathJax/MathJax.js?config=" + preDefinedConfig + "\"></script>" +
                        "<script type=\"text/x-mathjax-config\">" +
                        config +
                        "MathJax.Hub.Queue(function() {" +
                        "document.getElementById(\"formula\").style.visibility = '';" +
                        "var content = document.getElementById(\"formula\");" +
                        "AndroidInterface.getWidthContent(content.offsetWidth);" +
                        "});" +
                        "</script>" +
                        "<script type=\"text/javascript\" async src=\"file:///android_asset/MathJax/MathJax.js?config=" + preDefinedConfig + "\"></script>" +
                        "<body>" +
                        "<div id=\"formula\" style=\"visibility: hidden; margin: 0; width: fit-content; font-size: 22px; color: #3D4A54\">" +
                        text +
                        "</div>" +
                        "</body>", "text/html", "utf-8", "");
    }

    public void setTextGV(String text) {
        this.text = text;
        loadDataWithBaseURL("about:blank",
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">" +
                        "<html>" +
                        "<style>" +
                        "@font-face {" +
                        "font-family: MyFont; " +
                        " src: url(\"file:///android_asset/fonts/averta.ttf\") }" +
                        "body { font-family: MyFont }" +
                        "div {display: inline}" +
                        getStyle() +
                        "</style>" +
                        "<script type=\"text/javascript\" async src=\"file:///android_asset/MathJax/MathJax.js?config=" + preDefinedConfig + "\"></script>" +
                        "<script type=\"text/x-mathjax-config\">" +
                        config +
                        "MathJax.Hub.Queue(function() {" +
                        "document.getElementById(\"formula\").style.visibility = '';" +
                        "var content = document.getElementById(\"formula\");" +
                        "AndroidInterface.getWidthContent(content.offsetWidth);" +
                        "});" +
                        "</script>" +
                        "<body>" +
                        "<div style=\"font-size: 22px; color: #3D4A54\">" +
                        text +
                        "</div>" +
                        "</body>" +
                        "</html>", "text/html", "utf-8", "");
    }
}
