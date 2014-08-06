yieldUnescaped '<!DOCTYPE html>'
html {
  head {
    title('hello groovy templates')
  }
  body {
      div("hello $user.name")
  }
}