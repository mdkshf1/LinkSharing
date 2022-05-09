package enums

enum Visibility{
    PUBLIC,
    PRIVATE;
    def convert(String message)
    {
        message = message.toUpperCase()
        def result = message as Visibility
        return  result
    }
}


