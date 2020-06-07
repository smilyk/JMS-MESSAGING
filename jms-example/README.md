#
1 .Создаем POJO объект, который будет использоваться для отправки сообщений:
   
    - model.HelloWorldMessage
    
2 .Настройкa встроенного ActiveMQServer:

    - main
    
3 . Настройка конфигурации исполнителя задач:


    -config.TaskConfig
4 . Настраиваем конвертер сообщений с сообщениями JMS:

    - config.JSMConfig
    
5 . установливаем компонент, который будет отправлять все сообщени:


    - config.JSMConfig -> даем имя очереди
    - sender.HelloSender
    
6 . установливаем компонент, который будет слушать все сообщения:


    - listener.HelloMessageListener
    
7 . отправляем сообщение и ждем ответа:


    - listener.HelloMessageListener
    - config.JSMConfig -> даем имя второй очереди
    
8 . Attemis Active MQ:

    - docker run -it --rm \
        -p 8161:8161 \
        -p 61616:61616 \
        vromero/activemq-artemis
        
    - http://0.0.0.0:8161/console/login
    
    - artemis / 
    
    * https://github.com/vromero/activemq-artemis-docker
   
    
    


