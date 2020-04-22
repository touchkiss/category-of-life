<template>
    <el-dialog :title="title" :visible.sync="dialogVisible">
        <el-form
                ref="tLifeCategoryForm"
                :model="tLifeCategoryForm"
                :rules="rules"
                label-width="100px"
        >
            <el-main>
                <el-row :gutter="10">
                    <el-col :xs="24" :sm="24" :md="24" :lg="18" :xl="18">
                        <el-form-item label="snId" prop="snId">
                            <el-input
                                    v-model="tLifeCategoryForm.snId"
                                    type="text"
                                    placeholder="请输入snId"
                                    maxlength="45"
                                    show-word-limit
                                    clearable
                            ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :xs="24" :sm="24" :md="24" :lg="18" :xl="18">
                        <el-form-item label="名称" prop="name">
                            <el-input
                                    v-model="tLifeCategoryForm.name"
                                    type="text"
                                    placeholder="请输入名称"
                                    maxlength="200"
                                    show-word-limit
                                    clearable
                            ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :xs="24" :sm="24" :md="24" :lg="18" :xl="18">
                        <el-form-item label="分类等级" prop="type">
                            <el-select v-model="tLifeCategoryForm.type" placeholder="请选择">
                                <el-option label="界" value="kingdom"></el-option>
                                <el-option label="门" value="phylum"></el-option>
                                <el-option label="纲" value="class"></el-option>
                                <el-option label="目" value="order"></el-option>
                                <el-option label="科" value="family"></el-option>
                                <el-option label="属" value="genus"></el-option>
                                <el-option label="种" value="species"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :xs="24" :sm="24" :md="24" :lg="18" :xl="18">
                        <el-form-item label="parentId" prop="parentId">
                            <el-input
                                    v-model="tLifeCategoryForm.parentId"
                                    type="number"
                                    placeholder="请输入parentId"
                                    clearable
                            ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :xs="24" :sm="24" :md="24" :lg="18" :xl="18">
                        <el-form-item label="估计数量" prop="estimation">
                            <el-input
                                    v-model="tLifeCategoryForm.estimation"
                                    type="number"
                                    placeholder="请输入估计数量"
                                    clearable
                            ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :xs="24" :sm="24" :md="24" :lg="18" :xl="18">
                        <el-form-item label="估计来源" prop="estimateSource">
                            <el-input
                                    v-model="tLifeCategoryForm.estimateSource"
                                    type="text"
                                    placeholder="请输入估计来源"
                                    maxlength="300"
                                    show-word-limit
                                    clearable
                            ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :xs="24" :sm="24" :md="24" :lg="18" :xl="18">
                        <el-form-item label="是否灭绝" prop="isExtinct">
                            <el-select v-model="tLifeCategoryForm.isExtinct" placeholder="请选择">
                                <el-option label="已灭绝" value=true></el-option>
                                <el-option label="未灭绝" value=false></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :xs="24" :sm="24" :md="24" :lg="18" :xl="18">
                        <el-form-item label="前全新世" prop="hasPreholocene">
                            <el-select v-model="tLifeCategoryForm.hasPreholocene" placeholder="请选择">
                                <el-option label="是" value="true"></el-option>
                                <el-option label="否" value="false"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :xs="24" :sm="24" :md="24" :lg="18" :xl="18">
                        <el-form-item label="是否现生" prop="hasModern">
                            <el-select v-model="tLifeCategoryForm.hasModern" placeholder="请选择"
                                       prefix-icon="el-icon-search">
                                <el-option label="是" value="true"></el-option>
                                <el-option label="否" value="false"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :xs="24" :sm="24" :md="24" :lg="18" :xl="18">
                        <el-form-item label="image" prop="image">
                            <el-input
                                    v-model="tLifeCategoryForm.image"
                                    type="text"
                                    placeholder="请输入image"
                                    maxlength="1000"
                                    show-word-limit
                                    clearable
                            ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :xs="24" :sm="24" :md="24" :lg="18" :xl="18">
                        <el-form-item label="url" prop="url">
                            <el-input
                                    v-model="tLifeCategoryForm.url"
                                    type="text"
                                    placeholder="请输入url"
                                    maxlength="100"
                                    show-word-limit
                                    clearable
                            ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-main>
            <el-form-item>
                <el-button type="primary" @click="submitForm()">保存</el-button>
                <el-button type="danger" @click="resetForm()">重置</el-button>
                <el-button @click="dialogVisible=false">取消</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>
</template>
<style lang="scss">
    .el-form-item__label {
        font-size: 16px;
        width: 150px !important;
        line-height: 40px;
        text-align: right;
    }

    .el-form-item {
        .el-form-item__content {
            margin-left: 150px !important;
        }

        .el-input {
            min-width: 220px;
        }
    }
</style>
<script>
    export default {
        props: ['visible', 'title', 'id'],
        data() {
            return {
                dialogVisible: this.visible,
                tLifeCategoryForm: {
                    snId: '',
                    name: '',
                    type: '',
                    parentId: '',
                    numChildren: '',
                    estimation: '',
                    total: '',
                    nrFossil: '',
                    nrExtant: '',
                    estimateSource: '',
                    isExtinct: '',
                    hasPreholocene: '',
                    hasModern: '',
                    image: '',
                    url: '',
                    fetched: '',
                    create_time: '',
                    last_modify_time: ''
                },
                rules: {
                    snId: [
                        {required: false, message: '请输入', trigger: 'blur'}
                    ],
                    name: [
                        {required: false, message: '请输入名称', trigger: 'blur'}
                    ],
                    type: [
                        {required: false, message: '请输入分类等级', trigger: 'blur'}
                    ],
                    parentId: [
                        {required: false, message: '请输入', trigger: 'blur'}
                    ],
                    numChildren: [
                        {required: false, message: '请输入', trigger: 'blur'}
                    ],
                    estimation: [
                        {required: false, message: '请输入估计数量', trigger: 'blur'}
                    ],
                    total: [
                        {required: false, message: '请输入总数', trigger: 'blur'}
                    ],
                    nrFossil: [
                        {required: false, message: '请输入提供者数量', trigger: 'blur'}
                    ],
                    nrExtant: [
                        {required: false, message: '请输入现存数量', trigger: 'blur'}
                    ],
                    estimateSource: [
                        {required: false, message: '请输入估计来源', trigger: 'blur'}
                    ],
                    isExtinct: [
                        {required: false, message: '请输入是否灭绝', trigger: 'blur'}
                    ],
                    hasPreholocene: [
                        {required: false, message: '请输入是否是“前全新世”', trigger: 'blur'}
                    ],
                    hasModern: [
                        {required: false, message: '请输入是否现生', trigger: 'blur'}
                    ],
                    image: [
                        {required: false, message: '请输入', trigger: 'blur'}
                    ],
                    url: [
                        {required: false, message: '请输入', trigger: 'blur'}
                    ],
                    fetched: [
                        {required: false, message: '请输入是否经过爬取', trigger: 'blur'}
                    ],
                    create_time: [
                        {required: false, message: '请输入', trigger: 'blur'}
                    ],
                    last_modify_time: [
                        {required: false, message: '请输入', trigger: 'blur'}
                    ]
                }
            }
        },
        watch: {
            id() {
                this.init()
            },
            visible() {
                this.dialogVisible = this.visible
            },
            dialogVisible() {
                this.$emit('setDialogVisible', this.dialogVisible)
                this.init()
            }
        },
        methods: {
            init() {
                if (this.id != null && this.id !== '') {
                    this.$axios.get('life/lifeCategory/' + this.id + '/').then(result => {
                        Object.keys(result).forEach((key) => {
                            this.tLifeCategoryForm[key] = typeof (result[key]) === 'boolean' ? String(result[key]) : result[key]
                        })
                    })
                } else {
                    this.resetForm()
                    delete this.tLifeCategoryForm['id']
                }
            },
            submitForm() {
                this.$refs['tLifeCategoryForm'].validate(valid => {
                    if (valid) {
                        if (this.id != null && this.id !== '') {
                            this.tLifeCategoryForm.id = this.id
                            this.$axios
                                .put('life/lifeCategory/' + this.id + '/', this.tLifeCategoryForm)
                                .then(result => {
                                    this.saveSuccessed()
                                })
                                .catch(error => {
                                    this.saveFailed(error)
                                })
                        } else {
                            this.$axios
                                .post('life/lifeCategory/', this.tLifeCategoryForm)
                                .then(result => {
                                    this.saveSuccessed()
                                })
                                .catch(error => {
                                    this.saveFailed(error)
                                })
                        }
                    } else {
                        console.log('error submit!!')
                        return false
                    }
                })
            },
            resetForm() {
                this.$refs['tLifeCategoryForm'].resetFields()
            },
            saveSuccessed() {
                this.$emit('reloadData')
                this.$notify({
                    title: '成功',
                    message: '保存成功！',
                    type: 'success'
                })
                this.resetForm()
                this.dialogVisible = false
            },
            saveFailed(error) {
                console.log(error)
                this.$notify.error({
                    title: '错误',
                    message: '保存失败！'
                })
                this.resetForm()
                this.dialogVisible = false
            }
        }
    }
</script>
