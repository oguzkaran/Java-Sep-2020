package org.csystem.app.samples.findtextincurly;

public class FindTextInCurly {
    private String m_text;
    private String m_result;
    private boolean m_valid = true;

    public FindTextInCurly()
    {
        this("");
    }

    public FindTextInCurly(String text)
    {
        setText(text);
    }

    public String getText()
    {
        return m_text;
    }

    public String getResult()
    {
        return m_result;
    }

    public void setText(String text)
    {
        //...
        m_text = text;
        m_result = text;
        m_valid = true;
    }

    public boolean isValid()
    {
        return m_valid;
    }

    public void setValid(boolean valid)
    {
        m_valid = valid;
    }

    public void findText()
    {
        for (;;) {
            int begin = m_result.indexOf("{");
            int end = m_result.lastIndexOf("}");

            if (begin == -1 && end != -1 || begin > end) {
                m_valid = false;
                break;
            }

            if (end == -1)
                break;

            m_result = m_result.substring(begin + 1, end);
        }
    }
}
