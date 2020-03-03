object BannerCreator {
  val decor = ".｡:･・.｡:*･★.｡:･・.｡:*･★.｡:･・.｡:*･★.｡:･・.｡:*･★.｡:･・.｡:*･★"
  def create(message: String): String = {
    s"""${decor}
    |${message}
    |${decor}""".stripMargin
  }
}
