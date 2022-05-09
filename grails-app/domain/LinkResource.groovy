class LinkResource extends Resource{
    String url
    static constraints = {
        url unique : false, nullable : false, blank :false, url : true
    }

    @Override
    public String toString() {
        return "LinkResource{" +
                "url='" + url + '\'' +
                '}';
    }
}
