<template>
  <div>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Category Code</th>
          <th scope="col">Category Name</th>
          <th scope="col">Action</th>
        </tr>
      </thead>
      <tbody>
        <template v-for="(item, index) in listCategory" :key="item.id">
          <tr>
            <td>{{ index + 1 }}</td>
            <td>{{ item.categoryCode }}</td>
            <td>{{ item.categoryName }}</td>
            <td>
              <button type="button" class="btn btn-warning">Detail</button>
              <button
                type="button"
                class="btn btn-danger"
                @click="handleDelete(item.id)"
                style="margin-left: 10px"
              >
                Remove
              </button>
            </td>
          </tr>
        </template>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { deleteCategory, getCategories } from '@/service/CategoryService'
import { onMounted, ref } from 'vue'

const listCategory = ref([])
// ham goi get all trong service
const fetchCategories = async () => {
  try {
    const res = await getCategories()

    listCategory.value = res
  } catch (err) {
    console.error('Error fetching categories:', err)
  }
}
const handleDelete = async (id) => {
  // alert('aaaaa' + id)
  try {
    await deleteCategory(id)
    await fetchCategories()
  } catch (err) {
    console.error('Delete error:', err)
  }
}
// khi khoi tao component thi se hien thi du lieu
onMounted(fetchCategories)
</script>

<style scoped></style>
