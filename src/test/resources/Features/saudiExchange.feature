Feature: Industry market verification
  Scenario: market value dropdown verification
    When User is on the "https://www.saudiexchange.sa/wps/portal/saudiexchange" page
    When User navigates to the Issuer financial calendar page
    Then the Industry dropdown contain the following values
      | All (Market)                                 |
      | Energy                                       |
      | Materials                                    |
      | Capital Goods                                |
      | Commercial & Professional Svc                |
      | Transportation                               |
      | Consumer Durables & Apparel                  |
      | Consumer Services                            |
      | Media and Entertainment                      |
      | Consumer Discretionary Distribution & Retail |
      | Consumer Staples Distribution & Retail       |
      | Food & Beverages                             |
      | Household & Personal Products                |
      | Health Care Equipment & Svc                  |
      | Pharma, Biotech & Life Science               |
      | Banks                                        |
      | Financial Services                           |
      | In                                           |
      | Software & Services                          |
      | Telecommunication Services                   |
      | Utilities                                    |
      | REITs                                        |
      |                                              |