package ua.goit.javaDev8.hw4.dao;

public class MaxProjectsClient {
    String clientName;
    Integer projectCount;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(Integer projectCount) {
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxrojectsCount{" +
                "clientName='" + clientName + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
