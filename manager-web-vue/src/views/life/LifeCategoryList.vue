<template>
    <div>
        <el-card shadow="hover" class="box-card">
            <el-main>
                <el-row :gutter="10">
                    <el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="6" class="search-item">
                        <label class="search-title">物种id</label>
                        <el-input
                                placeholder="请输入物种id"
                                prefix-icon="el-icon-search"
                                v-model="queryTLifeCategoryParams.id"
                                maxlength="45"
                                show-word-limit
                                clearable
                        ></el-input>
                    </el-col>
                    <el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="6" class="search-item">
                        <label class="search-title">名称</label>
                        <el-input
                                placeholder="请输入名称"
                                prefix-icon="el-icon-search"
                                v-model="queryTLifeCategoryParams.name"
                                maxlength="200"
                                show-word-limit
                                clearable
                        ></el-input>
                    </el-col>
                    <el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="6" class="search-item">
                        <label class="search-title">分类等级</label>
                        <el-select v-model="queryTLifeCategoryParams.type" placeholder="全部"
                                   prefix-icon="el-icon-search">
                            <el-option label="全部" value=""></el-option>
                            <el-option label="界" value="kingdom"></el-option>
                            <el-option label="门" value="phylum"></el-option>
                            <el-option label="纲" value="class"></el-option>
                            <el-option label="目" value="order"></el-option>
                            <el-option label="科" value="family"></el-option>
                            <el-option label="属" value="genus"></el-option>
                            <el-option label="种" value="species"></el-option>
                        </el-select>
                    </el-col>
                    <el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="6" class="search-item">
                        <label class="search-title">父类id</label>
                        <el-input
                                v-model="queryTLifeCategoryParams.parentId"
                                type="number"
                                placeholder="请输入父类id"
                                prefix-icon="el-icon-search"
                                clearable
                        ></el-input>

                    </el-col>
                    <el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="6" class="search-item">
                        <label class="search-title">是否灭绝</label>
                        <el-select v-model="queryTLifeCategoryParams.isExtinct" placeholder="全部"
                                   prefix-icon="el-icon-search">
                            <el-option label="全部" value=""></el-option>
                            <el-option label="已灭绝" value="1"></el-option>
                            <el-option label="未灭绝" value="0"></el-option>
                        </el-select>
                    </el-col>
                    <el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="6" class="search-item">
                        <label class="search-title">前全新世</label>
                        <el-select v-model="queryTLifeCategoryParams.hasPreholocene" placeholder="全部"
                                   prefix-icon="el-icon-search">
                            <el-option label="全部" value=""></el-option>
                            <el-option label="是" value="1"></el-option>
                            <el-option label="否" value="0"></el-option>
                        </el-select>
                    </el-col>
                    <el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="6" class="search-item">
                        <label class="search-title">是否现生</label>
                        <el-select v-model="queryTLifeCategoryParams.hasModern" placeholder="全部"
                                   prefix-icon="el-icon-search">
                            <el-option label="全部" value=""></el-option>
                            <el-option label="是" value="1"></el-option>
                            <el-option label="否" value="0"></el-option>
                        </el-select>
                    </el-col>
                    <el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="6" class="search-item">
                        <label class="search-title">爬取状态</label>
                        <el-select v-model="queryTLifeCategoryParams.fetched" placeholder="全部"
                                   prefix-icon="el-icon-search">
                            <el-option label="全部" value=""></el-option>
                            <el-option label="已爬取" value="1"></el-option>
                            <el-option label="未爬取" value="0"></el-option>
                        </el-select>
                    </el-col>
                    <el-button
                            icon="el-icon-search"
                            circle
                            title="搜索"
                            @click="pageChange(1)"
                            class="search-button"
                    ></el-button>
                    <el-button
                            icon="el-icon-plus"
                            circle
                            title="添加"
                            @click="addTLifeCategory"
                            class="search-button"
                    ></el-button>
                </el-row>
            </el-main>
        </el-card>
        <el-divider></el-divider>
        <el-card shadow="hover" class="box-card">
            <el-table
                    :data="tLifeCategoryListData"
                    border
                    style="width: 100%"
                    @sort-change="sortChange"
            >
                <el-table-column
                        prop="image"
                        label="图片"
                        width="72px"
                >
                    <template slot-scope="scope">
                        <el-image
                                style="width: 40px; height: 40px"
                                v-if="scope.row.image"
                                :src="scope.row.image"
                                :fit="'cover'"></el-image>
                    </template>
                </el-table-column>
                <el-table-column
                        prop="name"
                        label="名称"
                        fit="true"
                        min-width="150px"
                        sortable
                ></el-table-column>
                <el-table-column
                        prop="id"
                        label="id"
                        sortable
                ></el-table-column>
                <el-table-column
                        prop="type"
                        label="分类"
                        sortable
                ></el-table-column>
                <el-table-column
                        prop="parentId"
                        label="父id"
                        sortable
                ></el-table-column>
                <el-table-column
                        prop="numChildren"
                        label="子类"
                        sortable
                ></el-table-column>
                <el-table-column
                        prop="total"
                        label="总数"
                        sortable
                ></el-table-column>
                <el-table-column
                        prop="nrExtant"
                        label="现存"
                        sortable
                ></el-table-column>
                <el-table-column
                        prop="isExtinct"
                        label="已灭绝"
                        sortable
                >
                    <template slot-scope="scope">{{scope.row.isExtinct?'是':'否'}}</template>
                </el-table-column>
                <el-table-column
                        prop="hasPreholocene"
                        label="前全新世"
                        sortable
                >
                    <template slot-scope="scope">{{scope.row.hasPreholocene?'是':'否'}}</template>
                </el-table-column>
                <el-table-column
                        prop="hasModern"
                        label="现生"
                        sortable
                >
                    <template slot-scope="scope">{{scope.row.hasModern?'是':'否'}}</template>
                </el-table-column>
                <el-table-column
                        prop="fetched"
                        label="已爬取"
                        sortable
                >
                    <template slot-scope="scope">{{scope.row.fetched?'是':'否'}}</template>
                </el-table-column>
                <el-table-column prop="createTime" label="创建时间" sortable>
                    <template slot-scope="scope">{{
                        scope.row.createTime | timestampToDate
                        }}
                    </template>
                </el-table-column
                >
                <el-table-column label="操作" fixed="right" fit="true" width="190">
                    <template slot-scope="scope">
                        <el-button
                                type="primary"
                                icon="el-icon-edit"
                                circle
                                :title="scope.row.id"
                                @click="editThisTLifeCategory(scope.row.id)"
                                class="table-button"
                        ></el-button>
                        <el-button
                                type="danger"
                                icon="el-icon-delete"
                                circle
                                slot="reference"
                                class="table-button"
                                @click="deleteThisTLifeCategory(scope.row.id)"
                        ></el-button>
                        <el-button
                                v-if="!scope.row.fetched"
                                type="primary"
                                icon="el-icon-caret-right"
                                circle
                                title="开始抓取"
                                slot="reference"
                                class="table-button"
                                @click="fetchWeb(scope.row.id)"
                        ></el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination
                    @size-change="sizeChange"
                    @current-change="pageChange"
                    :current-page="currentPage"
                    :page-sizes="[10, 20, 50, 100]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total"
            ></el-pagination>
        </el-card>
        <LifeCategoryItem
                :title="dialogTitle"
                @setDialogVisible="setDialogVisible"
                :visible="dialogVisible"
                :id="currentid"
                @reloadData="getTLifeCategoryList"
        ></LifeCategoryItem>
    </div>
</template>
<style lang="scss">
    .search-item {
        border-radius: 4px;
        margin: 5px 0;
        display: flex;

        .search-title {
            font-size: 16px;
            width: 180px;
            line-height: 40px;
            text-align: right;
            margin-right: 10px;
        }
    }

    .search-button {
        margin: 5px;
    }

    .table-button {
        margin: 0 5px;
    }

    .cell {
        white-space: nowrap !important;
    }

    .el-pagination {
        margin: 8px 10px 0 0;
        text-align: right;
    }
</style>
<script>
    import LifeCategoryItem from './LifeCategoryItem.vue'

    export default {
        name: 'TLifeCategoryList',
        components: {
            LifeCategoryItem
        },
        data() {
            return {
                tLifeCategoryListData: [],
                currentPage: 1,
                pageSize: 10,
                total: 0,
                queryTLifeCategoryParams: {},
                dialogVisible: false,
                dialogTitle: '',
                currentid: ''
            }
        },
        watch: {},
        created() {
            this.getTLifeCategoryList()
        },
        methods: {
            async getTLifeCategoryList() {
                let url =
                    'life/lifeCategory/?p=' + this.currentPage + '&pagesize=' + this.pageSize
                for (const key in this.queryTLifeCategoryParams) {
                    if (this.queryTLifeCategoryParams[key] !== null && this.queryTLifeCategoryParams[key] !== '') {
                        url += '&' + key + '=' + this.queryTLifeCategoryParams[key]
                    }
                }
                await this.$axios.get(url).then(result => {
                    this.tLifeCategoryListData = result.results
                    this.total = result.count
                })
            },
            sizeChange(size) {
                this.pageSize = size
                this.getTLifeCategoryList()
            },
            pageChange(page) {
                this.currentPage = page
                this.getTLifeCategoryList()
            },
            sortChange(sort) {
                // { column, prop, order }
                console.log(sort)
                this.queryTLifeCategoryParams['ordering'] =
                    (sort.order !== 'ascending' ? '-' : '') + sort.prop
                this.getTLifeCategoryList()
            },
            setDialogVisible(visible) {
                this.dialogVisible = visible
            },
            addTLifeCategory() {
                this.currentid = ''
                this.dialogTitle = '新增'
                this.dialogVisible = true
            },
            editThisTLifeCategory(id) {
                this.currentid = id
                this.dialogTitle = '编辑'
                this.dialogVisible = true
            },
            deleteThisTLifeCategory(id) {
                this.$confirm('真的要删除吗？', '提示', {
                    confirmButtonText: '删除',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios
                        .delete('life/lifeCategory/' + id)
                        .then(result => {
                            this.getTLifeCategoryList()
                            this.$notify({
                                title: '成功',
                                message: '删除成功！',
                                type: 'success'
                            })
                        })
                        .catch(() => {
                            this.$notify.error({
                                title: '错误',
                                message: '删除失败！'
                            })
                        })
                })
            },
            fetchWeb(id) {
                this.$axios
                    .post('spider/life/lifeCategory/' + id)
                    .then(result => {
                        this.getTLifeCategoryList()
                        this.$notify({
                            title: '成功',
                            message: '抓取成功！',
                            type: 'success'
                        })
                    })
            }
        }
    }
</script>
