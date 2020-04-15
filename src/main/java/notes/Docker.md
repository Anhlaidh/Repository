# Docker

- CentOS6.5及以上

## 概念&安装

- 镜像 一个只读的模板,创建Docker容器
- 容器 利用镜像创建的实例
- 仓库 集中存放镜像文件的场所


- 一般下载

```shell script
$ sudo yum install -y yum-utils

$ sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo
```
```shell script
$ sudo yum-config-manager --enable docker-ce-nightly
```
```shell script
$ sudo yum-config-manager --enable docker-ce-test

```
```shell script
$ sudo yum-config-manager --disable docker-ce-nightly
```
```shell script
$ sudo yum install docker-ce docker-ce-cli containerd.io
```
- 启动
```shell script
$ sudo systemctl start docker
```
- HelloWorld
```shell script
$ sudo docker run hello-world
```

### 改源
```shell script
sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://xxxxxxx.mirror.aliyuncs.com"]
}
EOF
sudo systemctl daemon-reload
sudo systemctl restart docker

```
### 优缺点

| | Docker容器 | 虚拟机(VM) |
| --- | --- | --- |
|操作系统 | 与宿主机共享OS| 宿主机OS上运行虚拟机OS|   
|存储大小 | 镜像小,便于存储与传输 | 镜像庞大(vmdk,vdi等) |
|运行性能|几乎无额外性能损失|操作系统额外的CPU,内存消耗|
|移植性|灵活,轻便,适应于Linux|面向硬件运维者|
|部署速度|快速,秒级|较慢,10s以上|

## 常用命令
### 帮助命令
```shell script
docker help
docker info
docker version
```
### 镜像命令
```shell script
docker images
```
- 当前主机上的镜像 
- `-a`全部镜像
- `-q`imageId
- `--digests` 详细信息
- `--no-trunc` 显示完整的镜像信息

```shell script
docker search xxx
```
- 查询镜像
- `-s [nums]`点赞数大于nums的
```shell script
docker pull xxx:[titile:默认不加]
```
    