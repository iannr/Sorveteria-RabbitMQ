import pika

# URL de conexão com o RabbitMQ na cloud
url = 'amqps://zckidaid:CeX1sv8xcu1W1oOarLOUrzHFBW3lRybq@prawn.rmq.cloudamqp.com/zckidaid'

# Função para receber o anúncio
def receber_anuncio(ch, method, properties, body):
    print(f"Recebido anúncio: {body.decode()}")

def main():
    # Cria a conexão com base no URL da cloud
    connection_params = pika.URLParameters(url)
    connection = pika.BlockingConnection(connection_params)
    channel = connection.channel()

    # Declara o exchange do tipo 'fanout'
    channel.exchange_declare(exchange='anuncios_sorvete', exchange_type='fanout')

    # Declara uma fila temporária e exclusiva para o consumidor
    result = channel.queue_declare(queue='', exclusive=True)
    queue_name = result.method.queue

    # Liga a fila ao exchange para receber as mensagens
    channel.queue_bind(exchange='anuncios_sorvete', queue=queue_name)

    # Consumidor escutando a fila
    channel.basic_consume(queue=queue_name, on_message_callback=receber_anuncio, auto_ack=True)

    print('Aguardando anúncios de novos sabores...')
    channel.start_consuming()

if __name__ == "__main__":
    main()
