# Actuator

# redis

## 启动redis 容器

```docker run --name redis -h redis -p 56379:6379 --restart=always -d redis:7```

## 连接redis

```docker exec -it myredis redis-cli```

```docker run -it --rm --network container:2abe53a846e0 redis:7-alpine redis-cli```

```docker run -it --rm redis7-alpine redis-cli -h some-redis -p```
