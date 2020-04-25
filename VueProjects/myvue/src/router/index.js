import Vue from 'vue'
import VueRouter from 'vue-router'
import StockQuery from "../views/StockQuery";
import StockAdd from "../views/StockAdd";
import StockUpdate from "../views/StockUpdate";
import Index from "../views/Index";


Vue.use(VueRouter)

  const routes = [
    {
      path:"/",
      name:"股票管理",
      redirect:"/stockQuery",
      component:Index,
      children:[
        {
          path:"/stockQuery",
          name:"查询股票信息",
          component:StockQuery
        },
        {
          path:"/stockAdd",
          name:"增加股票信息",
          component:StockAdd
        }
      ]
    },
    {
      path: '/stockUpdate',
      component: StockUpdate
    }
  ]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
