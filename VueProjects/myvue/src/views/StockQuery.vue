<template>
    <div>
        <el-table
            :data="tableData"
            border
            style="width: 100%">
        <el-table-column
                fixed
                prop="id"
                label="股票id"
                width="150">
        </el-table-column>
        <el-table-column
                prop="name"
                label="股票名"
                width="120">
        </el-table-column>
        <el-table-column
                prop="price"
                label="股票当前价格"
                width="120">
        </el-table-column>
        <el-table-column
                prop="rate"
                label="股票涨跌幅"
                width="120">
        </el-table-column>
        <el-table-column
                fixed="right"
                label="操作"
                width="100">
            <template slot-scope="scope">
                <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                <el-button @click="del(scope.row)" type="text" size="small">删除</el-button>
            </template>
        </el-table-column>
        </el-table>
        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total"
                @current-change="page">
        </el-pagination>
    </div>

</template>

<script>
    export default {
        methods: {
            edit(row) {
                this.$router.push({
                    path:'/StockUpdate',
                    query:{
                        id:row.id
                    }
                });
            },
            del(row){
                const _this=this;
                axios.delete('http://localhost:8181/stock/deleteById/'+row.id).then(function (resp) {
                    _this.$alert(row.name, '删除成功', '消息',{
                        confirmButtonText: '确定',
                        callback: action => {
                        }
                    });
                    window.location.reload();
                })
            },
            page(currentPage){
                const _this=this;
                axios.get('http://localhost:8181/stock/findAll/'+(currentPage-1)+'/6').then(function (resp) {
                    _this.tableData=resp.data.content;
                    _this.pageSize=resp.data.size;
                    _this.total=resp.data.totalElements;
                })
            }
        },

        data() {
            return {
                pageSize:'',
                total:'',
                tableData:''
            }
        },
        created() {
            const _this=this;
            axios.get('http://localhost:8181/stock/findAll/0/6').then(function (resp) {
                console.log(resp);
                _this.tableData=resp.data.content;
                _this.pageSize=resp.data.size;
                _this.total=resp.data.totalElements;
            })
        }
    }
</script>