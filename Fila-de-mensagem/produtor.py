import pika

# URL de conexão com o RabbitMQ na cloud
url = 'amqps://zckidaid:CeX1sv8xcu1W1oOarLOUrzHFBW3lRybq@prawn.rmq.cloudamqp.com/zckidaid'

# Configuração da conexão com o RabbitMQ usando o URL da cloud
def send_pedido(pedido):
    # Cria uma conexão com base na URL da cloud
    connection_params = pika.URLParameters(url)
    connection = pika.BlockingConnection(connection_params)
    channel = connection.channel()

    # Declara a fila no servidor da cloud para garantir que ela exista
    channel.queue_declare(queue='fila_sorvetes')

    # Envia o pedido para a fila
    channel.basic_publish(exchange='', routing_key='fila_sorvetes', body=pedido)
    print(f"Pedido enviado: {pedido}")

    connection.close()

if __name__ == "__main__":
    while True:
        pedido = input("Digite o pedido de sorvete (ou 'sair' para encerrar): ")
        if pedido.lower() == 'sair':
            break
        send_pedido(pedido)
