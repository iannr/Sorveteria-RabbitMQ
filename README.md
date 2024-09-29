Ian Nascimento Rocha

Diferença entre Fila de Mensagens (Pedidos de Sorvete) e Pub/Sub (Anúncio de Novos Sabores):

## 1. Fila de Mensagens (Pedidos de Sorvete):
   - Abordagem: Ponto a Ponto.
   - Funcionamento: Um produtor envia mensagens (pedidos de sorvete) para uma fila. Um consumidor consome essas mensagens uma por vez, seguindo a ordem de chegada.
   - Exemplo: Um cliente faz um pedido de sorvete e entra na fila. O atendente processa os pedidos um por um, de forma sequencial.
   - Benefícios: Útil quando o processamento das mensagens deve ser feito de forma ordenada, e cada mensagem só é consumida uma vez por um consumidor.
   - Caso de uso: Fila de atendimento de pedidos de sorvete.

## 2. Pub/Sub (Anúncio de Novos Sabores):
   - Abordagem: Publicação/Assinatura.
   - Funcionamento: Um produtor publica uma mensagem (anúncio de novo sabor) para um *exchange*. Todos os consumidores inscritos recebem a mensagem ao mesmo tempo.
   - Exemplo: A sorveteria anuncia um novo sabor de sorvete, e todos os clientes interessados são notificados simultaneamente.
   - Benefícios: Útil quando se deseja distribuir uma mensagem para vários consumidores ao mesmo tempo. Cada consumidor inscrito recebe uma cópia da mensagem.
   - Caso de uso: Notificação de novos sabores de sorvete para todos os clientes.

## Resumo:
- A fila de mensagens garante que as mensagens sejam processadas uma por vez, na ordem em que chegam, por um único consumidor.
- O Pub/Sub permite que uma mensagem seja distribuída para vários consumidores simultaneamente, o que é útil para broadcast de informações (como anúncios ou promoções).

