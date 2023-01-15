# spring-jpa-zuin-filter-library
In this repository you will find the source code responsible for all the logic of the zuin filter spring jpa.

The easiest way to create filters using spring, works to all your tables, all your columns, and only one dto request model.

![Badge em Primeira versão](https://img.shields.io/static/v1?label=STATUS&message=PRIMEIRA%20VERSAO&color=GREEN&style=for-the-badge "Sofrerá incrementos no futuro")

## Endpoint example 💻


- [x] Filter example.
   
 - Searching in table "HOSPITAL" with conditions.  
 ```json
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
 ```

![How it works - Json query](zuin-filter.png "Json query drawning")

### Author

---
ENAY ZUIN
---
