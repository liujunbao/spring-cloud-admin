# 开发指南

## Git 配置

### 代理设置

如果遇到 GitHub 连接问题，可以配置 Git 代理：
```bash
## 查看当前代理设置
git config --global --get http.proxy
git config --global --get https.proxy
设置代理（以 7890 端口为例）
git config --global http.proxy http://127.0.0.1:7890
git config --global https.proxy http://127.0.0.1:7890
取消代理
git config --global --unset http.proxy
git config --global --unset https.proxy