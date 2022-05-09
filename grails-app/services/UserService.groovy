class UserService {
    User getUserforLogin(String userName,String password)
    {
        User user = User.findByUserName(userName)
        if (user.password == password)
            return user
        return null
    }
}
