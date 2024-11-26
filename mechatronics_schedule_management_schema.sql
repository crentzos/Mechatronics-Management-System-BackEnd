-- Drop types and tables if they already exist
DROP TABLE IF EXISTS applications CASCADE;
DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS tasks CASCADE;
DROP TABLE IF EXISTS users CASCADE;

-- Drop ENUM types with CASCADE to remove dependencies
DROP TYPE IF EXISTS role_type CASCADE;
DROP TYPE IF EXISTS status_type CASCADE;

-- Define ENUM types for user roles and task/application statuses
CREATE TYPE role_type AS ENUM ('ADMIN', 'TEAM_LEADER', 'MECHANIC', 'ELECTRICIAN');
CREATE TYPE status_type AS ENUM ('PENDING', 'APPROVED', 'REJECTED', 'OPEN', 'IN_PROGRESS', 'COMPLETED', 'CLOSED');

-- Users table
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    availability BOOLEAN NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

-- User roles table (to assign roles to users)
CREATE TABLE user_roles (
    user_id BIGINT REFERENCES users(id) ON DELETE CASCADE,
    role role_type NOT NULL,
    PRIMARY KEY (user_id, role) -- Composite primary key to ensure a user can have multiple roles
);

-- Tasks table
CREATE TABLE tasks (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    posted_date TIMESTAMP NOT NULL,
    expiration_date TIMESTAMP,
    available_positions INT NOT NULL,
    role role_type NOT NULL, -- Role required for the task
    status status_type NOT NULL, -- Current status of the task
    location VARCHAR(255),
    created_by BIGINT REFERENCES users(id) ON DELETE SET NULL -- Reference to the user who created the task
);

-- Applications table (to track user applications for tasks)
CREATE TABLE applications (
    id BIGSERIAL PRIMARY KEY,
    application_date TIMESTAMP NOT NULL,
    status status_type NOT NULL, -- Current status of the application
    user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE, -- Reference to the user applying
    task_id BIGINT NOT NULL REFERENCES tasks(id) ON DELETE CASCADE, -- Reference to the task being applied for
    UNIQUE (user_id, task_id) -- Ensure a user can only apply once per task
);
