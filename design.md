# RESTful API Design – Task Management System

## Tổng quan

Hệ thống quản lý **Task (Công việc)** và **User (Người dùng)**.

* Một **User** có thể có nhiều **Task**
* Mỗi **Task** chỉ thuộc về **một User**
* API tuân thủ chuẩn **RESTful**:

    * Sử dụng **HTTP Method đúng ngữ nghĩa**
    * Sử dụng **danh từ số nhiều**
    * Stateless

---

## User APIs

### 1️ Lấy danh sách toàn bộ người dùng

```
GET /api/users
```

**Response 200 OK**

```json
[
  {
    "id": 1,
    "username": "nam",
    "role": "USER"
  }
]
```

---

### 2️ Tạo mới người dùng

```
POST /api/users
```

**Request Body**

```json
{
  "username": "nam",
  "password": "123456",
  "role": "USER"
}
```

**Response 201 Created**

---

### 3️ Cập nhật vai trò của người dùng

```
PATCH /api/users/{userId}/role
```

**Request Body**

```json
{
  "role": "ADMIN"
}
```

**Response 200 OK**

---

### 4️ Xóa người dùng khỏi hệ thống

```
DELETE /api/users/{userId}
```

**Response 204 No Content**

---

## ✅ Task APIs

### 5️ Lấy toàn bộ danh sách công việc

```
GET /api/tasks
```

**Response 200 OK**

```json
[
  {
    "id": 1,
    "title": "Fix bug",
    "priority": "HIGH",
    "status": "OPEN",
    "userId": 1
  }
]
```

---

### 6️ Tạo mới công việc

```
POST /api/tasks
```

**Request Body**

```json
{
  "title": "Write API",
  "priority": "HIGH"
}
```

**Response 201 Created**

---

### 7⃣ Cập nhật trạng thái công việc

```
PATCH /api/tasks/{taskId}/status
```

**Request Body**

```json
{
  "status": "DONE"
}
```

**Response 200 OK**

---

### 8⃣ Xóa một công việc

```
DELETE /api/tasks/{taskId}
```

**Response 204 No Content**

---

## 🔍 API Tìm kiếm & Lọc

### 9️ Tìm các công việc có độ ưu tiên HIGH

```
GET /api/tasks?priority=HIGH
```

---

### 10 Tìm công việc HIGH của user có id = 1

```
GET /api/users/1/tasks?priority=HIGH
```

---

### 11 Liệt kê toàn bộ công việc của một người dùng

```
GET /api/users/{userId}/tasks
```

---

## 🔗 Gắn công việc cho người dùng

### 12 Gán task cho user

```
PUT /api/tasks/{taskId}/assign/{userId}
```

**Response 200 OK**

---

## 📐 Quy ước thiết kế

| Thành phần | Quy ước                             |
| ---------- | ----------------------------------- |
| Resource   | Danh từ số nhiều (`users`, `tasks`) |
| Create     | POST                                |
| Read       | GET                                 |
| Update     | PUT / PATCH                         |
| Delete     | DELETE                              |
| Quan hệ    | `/users/{id}/tasks`                 |

---

## ✅ Ghi chú

* `PATCH` dùng khi cập nhật **một phần** tài nguyên
* `PUT` dùng cho hành động gán (assign)
* Không dùng động từ trong URL

---

📘 **Tài liệu này mô tả đầy đủ RESTful API cho hệ thống quản lý Task – User**
