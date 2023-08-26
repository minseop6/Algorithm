module.exports = {
  extends: ["eslint:recommended", "plugin:prettier/recommended", "airbnb"],
  rules: {
    "no-extra-semi": "error",
    "prettier/prettier": "error",
    "max-len": ["error", 120]
  }
}