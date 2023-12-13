const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

// 프록시 설정
// const target = 'http://localhost:8080'
// module.exports =
//   {
//     devServer: {
//       proxy: {
//         '/api': {
//           target,
//           changeOrigin: true
//         }
//       }
//     }
//   }