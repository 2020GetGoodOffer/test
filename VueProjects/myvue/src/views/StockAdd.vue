<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

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
            <el-button type="primary" @click="submitForm('ruleForm')">添加</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    name: '',
                    price: '',
                    rate: '',
                },
                rules: {
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
                        axios.post('http://localhost:8181/stock/save',this.ruleForm).then(function (resp) {
                            _this.$alert(_this.ruleForm.name, '添加成功', '消息',{
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
            }
        }
    }
</script>