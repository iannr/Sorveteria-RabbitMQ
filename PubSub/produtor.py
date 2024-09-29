import pika

# URL de conexão com o RabbitMQ na cloud
url = 'amqps://zckidaid:CeX1sv8xcu1W1oOarLOUrzHFBW3lRybq@prawn.rmq.cloudamqp.com/zckidaid'

# Configuração da conexão com o RabbitMQ usando o URL da cloud
def send_anuncio(anuncio):
    # Cria uma conexão com base na URL da cloud
    connection_params = pika.URLParameters(url)
    connection = pika.BlockingConnection(connection_params)
    channel = connection.channel()

    # Declara um exchange do tipo 'fanout'
    channel.exchange_declare(exchange='anuncios_sorvete', exchange_type='fanout')

    # Publica o anúncio para o exchange
    channel.basic_publish(exchange='anuncios_sorvete', routing_key='', body=anuncio)
    print(f"Anúncio enviado: {anuncio}")

    connection.close()

if __name__ == "__main__":
    while True:
        anuncio = input("Digite o anúncio de novo sabor de sorvete (ou 'sair' para encerrar): ")
        if anuncio.lower() == 'sair':
            break
        send_anuncio(anuncio)
