class User {
    Long id
    Long version
    String email
    String password
    String toString()
    {"$email"}
    static def constraints =
    {
        email(email: true)
        password(blank: false, password: true)
    }
}
