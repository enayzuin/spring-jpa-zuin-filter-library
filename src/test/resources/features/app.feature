Feature: API Example

  @tagGet
  Scenario Outline: Client makes call to GET
    Given client makes call to GET with <id>
    When client receives GET status code <status>
    Then client receives response <id>

    Examples:
      | id | status |
      | 1  | 200    |

  @tagPost
  Scenario Outline: Client makes call to POST
    Given client makes call to POST with "<someInfo>"
    When client receives POST status code <status>
    Then client receives POST response "<someInfo>"

    Examples:
      | someinfo | status |
      | info1    | 201    |

  @tagPut
  Scenario Outline: Client makes call to PUT
    Given client calls PUT with <id> and "<someInfo>"
    When client receives PUT status code <status>
    Then client receives PUT code <id> and "<someInfo>"

    Examples:
      | id | status | someInfo |
      | 1  | 200    | info2    |

  @tagDelete
  Scenario Outline: Client makes call to DELETE
    Given client makes call to DELETE with code <id>
    Then client receives status code <status>

    Examples:
      | id | status |
      | 1  | 204    |

