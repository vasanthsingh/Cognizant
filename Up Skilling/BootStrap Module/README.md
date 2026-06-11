Exercise 1–19 — Bootstrap beginner examples

This folder contains simple, beginner-friendly example pages that demonstrate Bootstrap
features for Exercises 1 through 19 from your assignment.

Files added
- exercise1-1.html  — Bootstrap via CDN (Exercise 1.1)
- exercise1-2.html  — Bootstrap from local/downloaded files (Exercise 1.2)
- exercise2.html     — Structure notes + bootstrap.bundle inclusion (2.1, 2.2)
- exercise3-grid.html
- exercise4-columns.html
- exercise5-alignment-reorder.html
- exercise6-flex-utils.html
- exercise7-typography.html
- exercise8-forms.html
- exercise9-buttons.html
- exercise10-nav.html
- exercise11-cards-media.html
- exercise12-spacing.html
- exercise13-colors.html
- exercise14-display.html
- exercise15-border-shadow.html
- exercise16-position.html
- exercise17-icons.html
- exercise18-plugins.html
- scss/_variables.scss  — sample variables for customization (19.2)
- scss/custom.scss      — starter scss file
- exercise19-sass.md    — instructions for Sass setup (19.1, 19.2)

Quick test instructions
1. Open any `exercise*.html` in your browser; they use CDN links and should work offline.
2. To use real local files with `exercise1-2.html`:

   ```powershell
   cd "BootStrap Module"
   npm install
   copy node_modules\\bootstrap\\dist\\css\\bootstrap.min.css local\\css\\
   copy node_modules\\bootstrap\\dist\\js\\bootstrap.bundle.min.js local\\js\\
   ```

3. For Sass customization (Exercise 19): install `sass` and compile `scss/custom.scss`:

   ```powershell
   npm install --save-dev sass
   npx sass scss/custom.scss css/custom.css --no-source-map
   ```

Want me to run `npm install` and copy Bootstrap into `local/` now? Reply with `install` to proceed.
