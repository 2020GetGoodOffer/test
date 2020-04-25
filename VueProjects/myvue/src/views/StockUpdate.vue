<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

        <el-form-item label="股票id" >
            <el-input v-model="ruleForm.id" readonly></el-input>
        </el-form-item>

        <el-form-item label="股票名称" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>

        <el-form-item label="当前价格" prop="price">
            <el-input v-model="ruleForm.price"></el-input>
        </el-form-item>

        <el-form-item label="股票涨跌幅" prop="rate">
            <el-input v-model="ruleForm.rate"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    id:'',
                    name: '',
                    price: '',
                    rate: '',
                },
                rules: {
                    id: [
                        { required: true, message: '请输入id', trigger: 'blur' },
                    ],
                    name: [
                        { required: true, message: '请输入名称', trigger: 'blur' },
                    ],
                    price: [
                        { required: true, message: '请输入价格', trigger: 'change' }
                    ],
                    rate: [
                        { required: true, message: '请输入涨跌幅', trigger: 'change' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this=this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.put('http://localhost:8181/stock/update',this.ruleForm).then(function (resp) {
                            _this.$alert(_this.ruleForm.name, '修改成功', '消息',{
                                confirmButtonText: '确定',
                                callback: action => {
                                }
                            });
                            _this.$router.push('/StockQuery');
                        })
                    } else {
                        return false;
                    }
                });
            },
            //重置表单
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
        },created() {
            const _this=this;
            axios.get('http://localhost:8181/stock/findById/'+this.$route.query.id).then(function (resp) {
                _this.ruleForm=resp.data;
            })
        }
    }
</script>