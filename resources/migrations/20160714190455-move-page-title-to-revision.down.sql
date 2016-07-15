ALTER TABLE pages ADD COLUMN title TEXT;
--;;
UPDATE pages SET title = revisions.title FROM revisions WHERE pages.id = revisions.page_id;
--;;
ALTER TABLE revisions DROP COLUMN title;
