# -*- coding: utf-8 -*-
import dash
import dash_core_components as dcc
import dash_html_components as html
import dash_table_experiments as dt
import requests
from requests.auth import HTTPDigestAuth
from dash.dependencies import Input, Output
import json
import pandas as pd



response = requests.get("http://localhost:8080/FenrirAPI/api/crypto")
# For successful API call, response code will be 200 (OK)
if(response.ok):

    # Loading the response data into a dict variable
    # json.loads takes in only binary or string variables so using content to fetch binary content
    # Loads (Load String) takes a Json file and converts into python data structure (dict or list, depending on JSON)
    jData = json.loads(response.content)

    print("The response contains {0} properties".format(len(jData)))
    print("\n")
    for coinInfo in jData:
        for key in coinInfo:
            print key , " : " , coinInfo[key]

    #dfItem = pd.DataFrame.from_records(response.json)
    print response.content
    dfItem = pd.read_json(response.content)
    new = dfItem.filter(['symbol','lastPrice','openPrice','priceChange','priceChangePercent','weightedAvgPrice'], axis=1)
    #dfTemp = df[['Moneda','Ultimo Precio','Precio Abierto','Cambio en precio','Cambio porcentual','Precio Promedio Ponderado']]
    new.columns = ['Moneda','Ultimo Precio','Precio Abierto','Cambio en precio','Cambio porcentual','Precio Promedio Ponderado']
    dfItem = new
    dfItem['Moneda'] = dfItem['Moneda'].map({'BTCUSDT': 'BITCOIN', 'ETHUSDT':'ETHEREUM','BCCUSDT':'BITCOIN CASH','XRPUSDT':'RIPPLE','ADAUSDT':'CARDANO','BNBUSDT':'BINANCE COIN','LTCUSDT':'LITECOIN','NEOUSDT':'NEO','QTUMUSDT':'QTUM'})
    #cols = list(dfItem.columns.values)
    dfItem['Ultimo Precio'] ='$' + dfItem['Ultimo Precio'].astype(str)
    dfItem['Precio Abierto'] ='$' + dfItem['Precio Abierto'].astype(str)
    dfItem['Cambio en precio'] ='$' + dfItem['Cambio en precio'].astype(str)
    dfItem['Cambio porcentual'] = dfItem['Cambio porcentual'].astype(str) + '%' 
    dfItem['Precio Promedio Ponderado'] ='$' + dfItem['Precio Promedio Ponderado'].astype(str)

    print dfItem
else:
  # If response code is not ok (200), print the resulting http error code with description
    response.raise_for_status()

response2 = requests.get("http://localhost:8080/FenrirAPI/api/tradeStats/volume")
if(response2.ok):
    dfItem2 = pd.read_json(response2.content)
    print dfItem2

colors = {
    'background': '#FFFFff',
    'text': '#000000'
}

def generate_table(dataframe, max_rows=15):
    
    return dt.DataTable(
        rows=dataframe.to_dict('records'),

        # optional - sets the order of columns
        columns=dataframe.columns,

        row_selectable=True,
        filterable=True,
        sortable=True,
        selected_row_indices=[],
        id='datatable-gapminder'
    )
    '''return html.Table(
        # Header
        [html.Tr([html.Th(col) for col in dataframe.columns])] +
        # Body
        [html.Tr([
            html.Td(dataframe.iloc[i][col]) for col in dataframe.columns
        ]) for i in range(min(len(dataframe), max_rows))],
        style={
            'textAlign': 'left',
            'color': colors['text']
        }
    )'''
monedas = {'Bitcoin':'Bitcoin', 'Ethereum':'Ethereum','Bitcoin cash':'Bitcoin cash','Ripple':'Ripple','Cardano':'Cardano','Binance coin':'Binance coin','Litecoin':'Litecoin','Neo':'Neo','Qtm':'Qtm'}
app = dash.Dash()

app.layout = html.Div(className="container",style={'backgroundColor': colors['background']}, children=[
    html.H1(
        children='Fenrir Crypto Board',
        style={
            'textAlign': 'center',
            'color': colors['text']
        }
    ),

    html.Div(children='Dashboard para ayudar en la toma de decisiones de compra de criptomonedas.', style={
        'textAlign': 'center',
        'color': colors['text']
    }),

    html.H4(children='Estadísticas Criptomonedas en Dolares'),
    generate_table(dfItem),


    html.Label('Estadística a graficar'),
    dcc.Dropdown(
        id='dropStat',
        options=[
            {'label': 'Volumen Promedio Transaccion', 'value': 'volume'},
            {'label': 'Valor Promedio Transacción', 'value': 'unitprice'},
            {'label': '# Transacciones hechas por mineros', 'value': 'makers'}
        ],
        value='volume',
        #multi=True
    ),

    dcc.Dropdown(
        id='dropCoin',
        options=[
            {'label':value, 'value':key} for key,value in monedas.iteritems()
        ],
        value=['BITCOIN'],
        multi=True
    ),

    dcc.Graph(
        id='graficaBarras',
        figure={
            'data': [
                {'y':[dfItem2.iloc[i]["stat"].astype(float)],'type':'bar', 'name': dfItem2.iloc[i]["coin"]} for i in range(min(len(dfItem2), 15))],
                
                #{'x': [1, 2, 3], 'y': [4, 1, 2], 'type': ''bar, 'name': 'SF'},
                #{'x': [1, 2, 3], 'y': [2, 4, 5], 'type': 'bar', 'name': u'Montréal'},
            
            'layout': {
                'plot_bgcolor': colors['background'],
                'paper_bgcolor': colors['background'],
                'font': {
                    'color': colors['text']
                }
            }
        }
    )
])

@app.callback(
    Output(component_id='graficaBarras', component_property='figure'),
    [Input(component_id='dropStat', component_property='value'),
    Input(component_id='dropCoin', component_property='value')]
)
def update_graph(option,monedas):
    print option
    print monedas
    #print "http://localhost:8080/FenrirAPI/api/tradeStats/"+option[0]
    print type(option)
    #if type(option)!='str':
    print "http://localhost:8080/FenrirAPI/api/tradeStats/"+str(option)
    response2 = requests.get("http://localhost:8080/FenrirAPI/api/tradeStats/"+str(option))
    #else:
    #    print "http://localhost:8080/FenrirAPI/api/tradeStats/"+option
    #    response2 = requests.get("http://localhost:8080/FenrirAPI/api/tradeStats/"+option)
    if(response2.ok):
        dfItem2 = pd.read_json(response2.content)
        print dfItem2
        #print dfItem2.columns
        tempDf = dfItem2[dfItem2['coin'].isin(monedas)]
        print tempDf
        if len(tempDf)== 0 :
            tempDf = dfItem2
        #df.loc[~df['column_name'].isin(some_values)]

    return {
            'data': [
                {'y':[tempDf.iloc[i]["stat"].astype(float)],'type':'bar', 'name': tempDf.iloc[i]["coin"]} for i in range(min(len(tempDf), 15))],
                
                #{'x': [1, 2, 3], 'y': [4, 1, 2], 'type': ''bar, 'name': 'SF'},
                #{'x': [1, 2, 3], 'y': [2, 4, 5], 'type': 'bar', 'name': u'Montréal'},
            
            'layout': {
                'plot_bgcolor': colors['background'],
                'paper_bgcolor': colors['background'],
                'font': {
                    'color': colors['text']
                }
            }
        }



def update_selected_row_indices(clickData, selected_row_indices):
    if clickData:
        for point in clickData['points']:
            if point['pointNumber'] in selected_row_indices:
                selected_row_indices.remove(point['pointNumber'])
            else:
                selected_row_indices.append(point['pointNumber'])
    return selected_row_indices

app.css.append_css({
    'external_url': 'https://codepen.io/chriddyp/pen/bWLwgP.css'
})    

if __name__ == '__main__':
    app.run_server(debug=True)