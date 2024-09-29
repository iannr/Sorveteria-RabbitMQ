import pika

# URL de conexão com o RabbitMQ na cloud
url = 'amqps://zckidaid:CeX1sv8xcu1W1oOarLOUrzHFBW3lRybq@prawn.rmq.cloudamqp.com/zckidaid'

# Função para processar o pedido
def processar_pedido(ch, method, properties, body):
    print(f"Atendendo pedido: {body.decode()}")
    print(f"Sorvete de {body.decode()} pronto!")

def main():
    # Cria a conexão com base no URL da cloud
    connection_params = pika.URLParameters(url)
    connection = pika.BlockingConnection(connection_params)
    channel = connection.channel()

    # Declara a fila no servidor da cloud para garantir que ela exista
    channel.queue_declare(queue='fila_sorvetes')

    # Consumidor escutando a fila
    channel.basic_consume(queue='fila_sorvetes', on_message_callback=processar_pedido, auto_ack=True)

    print('Aguardando pedidos...')
    channel.start_consuming()

if __name__ == "__main__":
    main()
