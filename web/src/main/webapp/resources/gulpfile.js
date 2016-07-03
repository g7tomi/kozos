var packageJSON = require('./package.json');
var gulp = require('gulp');
var uglify = require('gulp-uglify');
var watch = require('gulp-watch');
var concat = require('gulp-concat');
var ngAnnotate = require('gulp-ng-annotate');
var rename = require('gulp-rename');
var watch = require('gulp-watch');
var clean = require('gulp-clean');
var sass = require('gulp-sass');
var copyDir = require('copy-dir');
var bulkSass = require('gulp-sass-bulk-import');
var sourcemaps = require("gulp-sourcemaps");
var source = require('vinyl-source-stream')
var buffer = require('vinyl-buffer')

var browserify = require('browserify')
var babelify = require('babelify')

gulp.task('build', ['buildjs', 'copy:thirdparty', 'copy:templates', 'copy:css','copy:fontbootstrap', 'copy:fontawesome','sass']);
gulp.task('build-develop', ['buildjs', 'copy:templates', 'sass']);


function buildjs() {
  var bundler = browserify(packageJSON.config.basedir+'app/index.js').transform(babelify, {/* options */ })

  return bundler.bundle()
    .pipe(source('app.js'))
    .pipe(buffer())
    .pipe(rename('app.min.js'))
    //.pipe(uglify())
    .pipe(gulp.dest(packageJSON.config.destdir))
}
gulp.task('buildjs', buildjs);
          
function development() {
    watch([packageJSON.config.basedir + '/scss/**/*.scss', packageJSON.config.basedir + '/app/**/*.js', packageJSON.config.basedir + '/app/**/*.tpl']
        , function () {
            gulp.start('build-develop');
        });
}
gulp.task('development', development);



function copySass() {
    return gulp.src(packageJSON.config.basedir + '/scss/app.scss')
		.pipe(bulkSass())
        .pipe(sass({
                    includePaths: [packageJSON.config.basedir + '/scss/stylesheets']
                }))
        .pipe(concat('app.css'))
        .pipe(gulp.dest(packageJSON.config.destdir + '/css/'));
}
gulp.task('sass', copySass);



function copyTemplates() {
    return gulp.src(packageJSON.config.basedir + '/app/**/*.tpl')
        .pipe(gulp.dest(packageJSON.config.destdir ));
}
gulp.task('copy:templates', copyTemplates);



function resetDist() {
    return gulp.src('./dist', {
            read: false
        })
        .pipe(clean());
}
gulp.task('resetdist', resetDist);


function copyFont() {
    return copyDir.sync(
        'node_modules/bootstrap/dist/fonts'
        , packageJSON.config.destdir + '/fonts/bootstrap/');
}
gulp.task('copy:fontbootstrap', copyFont);

function copyFontAwesome() {
    return copyDir.sync(
        'node_modules/font-awesome/fonts'
        , packageJSON.config.destdir + '/fonts/fontawesome/');
}
gulp.task('copy:fontawesome', copyFontAwesome);




function buildScripts() {
    gulp.src([
            packageJSON.config.basedir + '/js/app/**/*controller.js',
            packageJSON.config.basedir + '/js/app/**/*filter.js',            
            packageJSON.config.basedir + '/js/app/**/*service.js',
            packageJSON.config.basedir + '/js/app/**/*factory.js',
            packageJSON.config.basedir + '/js/app/**/*config.js',           
            packageJSON.config.basedir + '/js/app/**/*directive.js',
            packageJSON.config.basedir + '/js/app/**/*run.js',
            packageJSON.config.basedir + '/js/app/**/*module.js',
            packageJSON.config.basedir + '/js/app/index.js'
    ])
        .pipe(concat('app.js'))
        .pipe(ngAnnotate({
            add: true
        }))
        //   .pipe(uglify({
        //        mangle: true
        //   }))
        //    .pipe(rename({
        //        extname: '.min.js'
        //    }))
        .pipe(gulp.dest(packageJSON.config.destdir));
}
gulp.task('build:js', buildScripts);

function copyThirdParty() {
    return gulp.src([
            'node_modules/angular/angular.js',
            'node_modules/angular-ui-router/release/angular-ui-router.min.js',
            'node_modules/angular-animate/angular-animate.min.js',
            'node_modules/angular-aria/angular-aria.min.js',
            'node_modules/angular-ui-bootstrap/dist/ui-bootstrap-tpls.js',
            'node_modules/angular-messages/angular-messages.min.js',
			'node_modules/angular-touch/angular-touch.min.js',
            'node_modules/lodash/dist/lodash.min.js',
            'node_modules/angular-toastr/dist/angular-toastr.tpls.js'

    ])
        .pipe(gulp.dest(packageJSON.config.destdir + '/lib'));
}
gulp.task('copy:thirdparty', copyThirdParty);


function copyCSS() {
    return gulp.src([
        'node_modules/angular-ui-bootstrap/dist/ui-bootstrap-csp.css',
        'node_modules/font-awesome/css/font-awesome.css',
        'node_modules/angular-toastr/dist/angular-toastr.css'
    ])
        .pipe(gulp.dest(packageJSON.config.destdir + '/css'));
}
gulp.task('copy:css', copyCSS);