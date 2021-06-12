package org.csystem.app.io.file.devicespersistence.entity;

public class DeviceInfo {
    private int m_id;
    private String m_name;
    private String m_host;

    public DeviceInfo(int id, String name, String host)
    {
        m_id = id;
        m_name = name;
        m_host = host;
    }

    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public String getHost()
    {
        return m_host;
    }

    public void setHost(String host)
    {
        m_host = host;
    }

    public String toString()
    {
        return String.format("[%d]%s-%s", m_id, m_name, m_host);
    }
}
