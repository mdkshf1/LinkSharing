import java.text.SimpleDateFormat

class SimpleTagLib {
    def simple = {attrs,body->
        out << body() << (attrs.happy == 'true' ? " :-)" : " :-(")
        out << body() << (attrs.happy == 'true' ? " :-)" : " :-(")
    }
    def dateFormat = {attrs,body ->
        out << new SimpleDateFormat(attrs.format).format(attrs.date)
    }
    def check = {attrs,body ->
        Integer number = Integer.parseInt(attrs.number)
        if (number %2 == 0)
        {
            out<< body()
        }
    }
    def print = {attrs,body->
        Integer number1 = Integer.parseInt(attrs.number1)
        Integer number2 = Integer.parseInt(attrs.number2)
        for (int i = number1;i<number2;i++)
        {
            out << body(i)
        }
    }

    static namespace = "my"
    def example = { attrs, body->
        if (attrs.hello == 'true')
            out <<body()
    }
}
//how to make a self closing tag
//what if taglib throws exception