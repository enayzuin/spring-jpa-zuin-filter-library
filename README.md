# spring-jpa-zuin-filter-library
In this repository you will find the source code responsible for all the logic of the zuin filter spring jpa.

The easiest way to create filters using spring, works to all your tables, all your columns, and only one dto request model.

![Badge em Primeira versão](https://img.shields.io/static/v1?label=STATUS&message=PRIMEIRA%20VERSAO&color=GREEN&style=for-the-badge)


<a href="https://viewer.diagrams.net/index.html?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=zuin-filter.drawio%20(4).png#R7V1bc6M4Fv41qdp9cApx59FJ3L1dm056k8xO99MUMYrNNgY34I4zv34lgbhjMDEgHHlqOiCBQDqfvnN0kI4upOvN%2FrNvbtdfPQs6F6Jg7S%2BkmwtRFGVNRn9wylucIqhxysq3rSgNpAmP9t8wThTi1J1twSB3Yeh5Tmhv84lLz3XhMsylmb7vveYve%2FGc%2FFO35gqWEh6XplNO%2FdO2wnWUqotamv4vaK%2FW9MlANaKcjUkvjmsSrE3Le80kSYsL6dr3vDA62uyvoYNbj7ZLdN%2BnmtzkxXzohm1u%2BJ%2B61H%2Bqc%2BvX7Pbr51%2BzT3p4%2F%2FfMiKXx23R2cY3jtw3faBP43s61IC5FuJCuXtd2CB%2B35hLnviKpo7R1uHHQGUCHL54bxlIEIj2PyyL5tuNce47nk7IlCCwFaig9CH3vJ8zkGKommWp8By3B3IUeSlr5pmWjamcu%2F0R%2B8QMz6fIN%2Fg%2Bll5srbsHf0A%2FhPpMUN99n6G1g6L%2BhS%2BLcmQ6MSyW6K8bzTFNj8b6m6ACimFy3zoJDj681Y1CukkekckMHseiOESMYV4yWCfWXZZUYBfJjXoxAEHWa1kaSwOhLksLIklSgbslVktTFZ0mt6ZBDSwsc0%2Bt6k5UucfI8A%2FLUxXHF%2BPIC1eWUydMQjhCjJNDk0wtyWty5NsPlmi1JMkKsVdaM6oS4Zbemi45X%2BPhpfnW7oBnoOdm8ktwbJG0G22j08GLvMToOitr1XHi4u%2FYoNVGTylJTylKjnSErsd4otAWDQtea4%2FEYOls6ZhDYy7wE8h0T7u3we%2Bb4Bz5G9Y7ObvaZrJs3euKiqnyPiyMnP7I56U3kjN5VEnSN7OqlXSvVwNv5S9iM89D0VzA8cJ0aXQet3Fi1jJGM%2BJUK8dM0HzpmaP%2FOj3CrMBE%2F4Ztno5olEJQENY8%2FxSgQQVTx%2BLbskLRQklooyCgyStQypYIIRpN6d4dtlf0W0QlGQQ6%2F6q%2BdRzNmAdEJc3QBANs9gQDNTwmoTFiL798eFo%2BPX%2B7valkrSY5eYAAym9roDRhigf0EwRiX%2FVQOo8nBaKYJzOFI4ziaHo6q7LHRkaT3Zo8lNtgPamg122PxTedkkWlnapFJSqEkVR7WJDP6Qi646DCSEM4NtxLHbT%2B4Bf0Ngc%2BcctWW0AUKW9gtIk4vDl7bYhdIhZK0obFbHgdf39%2FdfHkipmG%2Fxt60nN8y0AtCV0e29Giv4LJrHPDpzMmu7DjgsquUnSowJ7uqwTrX96fU94x5vU%2Bm72WxUJKsDazvGXMPnB1yGRtlnQ9yxaov%2FGXPZkaLDv91eGrKtfRBZXTdSuloAnYRncPRq4dZZM34EaczYBxCQBJz8mkxq5sbpwf8%2Bo0qnjYoIypeVAscrhQVc2tHKiiUpIoDq%2FiyQ4Nj97TYZcs8LdkfWhFxbbE7K3rnBsdu1UwQjt0W2JXaYldgCrszsQi5zsQ7A%2BrY6O3NLXCCb68plBlEb1vHAFuzBmZGEXBCV%2BzKxZKUgaHLxLSBKSh%2FtnT%2FGUFQKrum5nc3JRSiMWWYx10eDfHagorlBqZjr1wMXoQNiNKv8AjVXprOPM7Y2JaFH1O5qiWP7rZIrcXjEaNjpSgZgxp82TUmUgXIpL7Gx9LJNV12pRDoSB9T1Hz08%2FPUvuacEfHI7Xzi998WD%2FNjfOIfj6k0GtUhceQp0shMJZeXwnGtQrRKC50C5CEldXKf60fVKbThpubIOiedUuWE5TqlA0%2BBomdeV8a2fmUmrd9RrdiJzuw4J8ap8uBwxuk03maOcZR2AR2OXu0o1qx2%2FO%2F89o9F7erFHqcEZTiwc%2Byeg9MYmJk8rY49x0Hp1d4WM1rsmG9vAaLJkD6Tckt%2Fmq1RYdGex4rC0kp6puuKrxkozgkfWmUpVXYUZ7UOrDbo0oHRmUtt57DjuBkVN6WlXuPjRmRR43WdbcKcptTZ0pRKaTrIdDWlym21NlG%2BGJvbJGn6pZD5ycr5ALI%2BZBNXwcyo4NLCh%2FFV8MlXfX4gFdw8jU5vy5SMTSYAysn8sONTYztHLKfGUamxuORodGbUWsRe5szYlRm11jakwZmxL2bUqsbfnBnZYsbSaqLxmbHFLhGcGTszo9ySGWnv5czYAzPWTxdag3K42ccMe6X5NHGbxPdfQ1Tmrx0kYllilhPW5m%2BceIcFud%2F6EHUVzw1wTV2L%2FPuWy6m6b%2Bm5lh3i2y7R2RW%2BwYIv5s4JS4Xa%2BFYT%2Fe%2FYQUigQdoiLiwk70emYwreFvpmiHCd7ERmu6voms1lprrbWqbuPlEBKYAlfpp0o6RnTx6i%2Bhu8Xq56foKHKPXFIb14bVsWdBtZpqGXJ5%2BhHfMZOlfm8ueKlEcvoW18okkOhlyMuqtUbV1hVPRgIPZG9fVupRTnxW0rGnvA1sfoCt8Iyz07kJAPhilqvyDBIc1yzQ2k0LVMlGoGkAPw5ACs2DyFBQDWhxBPYZaE6jiKh1PaTInwGaZ8h452QUJ6BUpce14ALQrLKD%2FL0tf43ES2YeY5Jb41ya0%2BzPQJG28NOa%2BGd6EWALP9iw3x%2Fo%2Fz5CXSHoIe7Ow2btKDWhQpXtKmDrJlRo2P96kkT3Tw7LE2xUmX5C02CJik3UiRr8hmziRH7YLAsvasghx2UQvnnoreyA6SenMWODULSOmugUezQI8jjvqJKWk3r5pJ2YYEiG1DUPgMw1cI3SI3JEZT2sFrLKCqHkrMqbZ97%2F6BY%2FrkmFbfodiU3iBd75XOKrav3%2BYI1DlYHMD0dTWppriOaTMeXJBnt4Ny3i%2F0Dh8Q6ROL%2F%2Fwxv0V%2F%2F4G1qkusuxBu0J9%2F1rqBhnzHxoLqbym8N%2BnUnx8W86fFw0eoL9H4t1%2F%2BvfgIlZVJZRePj8NXtvyOSgZpfyX966hXevanLhGVSuSvD8MwGq7y3f3T4RqbG6zH3edgW1%2FSVFtAJ16vxdOfi8VdXP%2Fw1YvrH5yhyA1c4S%2B0ru4Z1xQIFN0fo7qAVveQCj3nvgxE2gKn69B87PSOj4%2By0mbsJKqJ8zo7epLVvkZP%2BnHzb2MB9vr9kYWgNax8CiwtitL0rp8Cy0UNHERQPy586xBQm2I8TNbCJZVWI3SHaLmooSF6XJTWs2dDxmIaNC076I68xpIHBqLabgFppVuTBz3ILxWgkbpKshwt6IF%2B3FoBrgnfGQ1KZWwBH9D74rGmkpMpj0NN%2F2oX3oPzWDOPqezR2HHRojiNHY5V1zxPla2IHeDSyPwUuaRnu7JYU8GDk1iVj4STWBcvmFoIo8oAiR0XH56T2OHdN5pJTGaKxESpwDanMsWaCh6axOjilwlszDbyjsLM7dlmTGdPvZFFx95%2BiEa7cLk0ja8M5CsDCWx4FBL2YcPeUnujfpEHh80EFBiDRMQjWU4aUQxyFI8iM21EsRd7Cwg8buq0McVeSFUg8Mj008YUe%2BGdgdDOG8C%2FJLRgDJm576FJsBUu3vd3XolB8bazXLl4m8WrgwHFi059D%2Bva9HsKqv%2F6q2dBfMX%2FAQ%3D%3D">

## Endpoint example 💻


- [x] Filter example.
   <details><summary>Searching in table "HOSPITAL" with conditions </summary>
        <p>
  
	{
	   "table":"HOSPITAIS",
	   "expressions":[
		  {
			 "conditions":[
				{
				   "field":"ID",
				   "values":[
					  "1"
				   ],
				   "comparator":"EQUAL"
				},
				{
				   "field":"NOME_HOSPITAL",
				   "values":[
					  "UNIDADE SANTO AMARO"
				   ],
				   "comparator":"EQUAL"
				}
			 ],
			 "operation":"AND"
		  }
	   ]
	}
   
<br>

### Author

---
ENAY ZUIN
---
