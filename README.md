# ProyectoFinalFenrir
Final Project developed for ADSI (Analisis y Diseño de Sistemas de Información) @ITAM
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Make sure to have Python 2.7 and Java, the web API is built in java and the Web UI is built using Dash, Plot.ly's binder for React.js

```
pip install dash==0.21.1  
pip install dash-renderer==0.12.1  
pip install dash-html-components==0.10.1  
pip install dash-core-components==0.23.0  
pip install plotly --upgrade 
pip install dash-table-experiments
```

### Installing
```
git clone <this-repo>
```

When testing make sure the web api is running on port 8080, otherwise change the port in the python file uri

### Installing

To run the UI just go to the "DashApp" folder through cmd and type
```
python app.py
```

The console will inidcate on whic port the web application is running and you can access it through any web browser.

## Built With

* [Dash](https://dash.plot.ly/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Netbeans](https://netbeans.org/) - IDE with an integrated Glassfish server 

## Authors

* **Pablo Lopez Quiles** -  [Piblo](https://github.com/pablolq)