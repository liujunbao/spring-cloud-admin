<template>
  <div class="dashboard-container">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>系统信息</span>
        </div>
      </template>
      <div class="welcome-text">
        欢迎使用后台管理系统
      </div>
    </el-card>
  </div>
</template>

<script setup>
</script>

<style lang="scss" scoped>
.dashboard-container {
  .welcome-text {
    font-size: 16px;
    color: #666;
  }
}
</style> 