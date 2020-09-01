package rabbitmq;

public class EmailData {
  private String project;
  private String url;

  public EmailData() {
  }

  public void setProject(String project) {
    this.project = project;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "EmailData{" +
            "project='" + project + '\'' +
            ", url='" + url + '\'' +
            '}';
  }

  public String getProject() {
    return project;
  }

  public String getUrl() {
    return url;
  }
}
