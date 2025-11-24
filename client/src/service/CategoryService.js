// cau noi de lay API tu ben back-end
// http://localhost:8080/api/category-management
// bien json -> list fix cung
const API = 'http://localhost:8080/api/category-management'

export const getCategories = async () => {
  const res = await fetch(`${API}`)
  if (!res.ok) throw new Error('Failed to fetch categories')
  return await res.json()
}

// export const createCategory = async (data) => {
//   const res = await fetch(`${API}/add`, {
//     method: 'POST',
//     headers: { 'Content-Type': 'application/json' },
//     body: JSON.stringify(data),
//   })
//   return await res.json()
// }
export const createCategory = async (data) => {
  const res = await fetch(`${API}/add`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data),
  })

  if (!res.ok) throw new Error(await res.text())

  return null // vì server không trả gì
}
// export const updateCategory = async (id, data) => {
//   const res = await fetch(`${API}/update/${id}`, {
//     method: 'PUT',
//     headers: { 'Content-Type': 'application/json' },
//     body: JSON.stringify(data),
//   })
//   return await res.json()
// }
export const updateCategory = async (id, data) => {
  const res = await fetch(`${API}/update/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data),
  })

  if (!res.ok) {
    const errText = await res.text()
    throw new Error(errText || `HTTP error ${res.status}`)
  }

  const text = await res.text()
  return text ? JSON.parse(text) : null // body rỗng thì không parse
}

export const deleteCategory = async (id) => {
  const res = await fetch(`${API}/delete/${id}`, {
    method: 'DELETE',
  })
  if (!res.ok) {
    const error = await res.text()
    throw new Error('Delete failed: ' + error)
  }
}

export const getCategoryById = async (id) => {
  const res = await fetch(`${API}/${id}`)
  if (!res.ok) throw new Error('Failed to fetch category detail')
  return await res.json()
}
