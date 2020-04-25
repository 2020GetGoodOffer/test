<template>
    <div>
        <table>
            <tr>
                <th>股票id</th>
                <th>股票名</th>
                <th>股票当前价格</th>
                <th>股票涨跌幅</th>
            </tr>
            <tr v-for="stock in stocks">
                <td>{{stock.id}}</td>
                <td>{{stock.name}}</td>
                <td>{{stock.price}}</td>
                <td>{{stock.rate}}</td>
            </tr>
        </table>
        {{msg}}
    </div>
</template>

<script>
    export default {
        name: "Stock",
        data(){
            return{
                msg:'Hello Vue',
                stocks:[
                    {
                        id: 1,
                        name: '科技股',
                        price: 34.12,
                        rate: +5.32
                    },
                    {
                        id: 2,
                        name: '教育股',
                        price: 27.12,
                        rate: -3.17
                    }
                ]
            }
        },
        created() {
            const _this=this;
            axios.get('http://localhost:8181/stock/findAll').then(function (resp) {
                _this.stocks=resp.data;
            })
        }
    }
</script>

<style scoped>

</style>