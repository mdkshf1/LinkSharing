class DocumentResource extends Resource{
    String filePath
    static constraints = {
        filePath unique : true, nullable : false, blank : false
    }

    @Override
    public String toString() {
        return "DocumentResource{" +
                "filePath='" + filePath + '\'' +
                '}';
    }
}
